package com.example.demo.repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.service.IEntityRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomRepository implements IEntityRepository{

	private final JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CustomRepository.class);
	
	private String[] fieldsp;
	private Field[] Fieldsp;
	private Object[] fieldspValue;
	private int SaveOrUpdate = 1;
	
	@Override
	public <T> List<T> getAllRecords(Class<T> clazz) {
		return jdbcTemplate.query("select * from " + clazz.getSimpleName(), new LombokRowMapper<T>( clazz ));
	}

	@Override
	public <T> int SaveRecord(T save) {
		SaveOrUpdate = 1;
	    getFieldsCustom(save);
       		
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
            .append( save.getClass().getSimpleName() )
            .append( "(" ).append( String.join( ",", fieldsp) ).append( ")" )
            .append( " VALUES " )
            .append( "(" ).append( String.join( ",", Collections.nCopies( fieldsp.length, "?") ) ).append( ")" );
		
       
		return jdbcTemplate.update(sql.toString(), fieldspValue);
		
	}

	@Override
	public <T> T FindById(Long id, Class<T> clazz) {
		String sql = "Select * from " + clazz.getSimpleName() + " where nopaciente = " + id;
         System.out.println(new LombokRowMapper<>(clazz));
		return jdbcTemplate.queryForObject(sql, new LombokRowMapper<>(clazz));
	}

	@Override
	public <T> List<T> getRecordsContaning(Class<T> clazz,  String name) {
		return jdbcTemplate.query("Select * from " + clazz.getSimpleName() + " where name like '%" + name + "%'", new LombokRowMapper<>(clazz));
	}

	@Override
	public <T> int UpdateRecord(T update) {
    
		SaveOrUpdate = 0;
		
		getFieldsCustom(update);
		
   		StringBuilder sqle = new StringBuilder();
		StringBuilder sql = new StringBuilder();
        sql.append("update ")
            .append( update.getClass().getSimpleName() )
            .append( " set " );
		
        for (int i = 0; i<fieldsp.length; i++) {
		
			if(!fieldsp[i].equals("nopaciente")) {
				sql.append(fieldsp[i]).append("=").append("'").append(fieldspValue[i]).append("'");
			}else {
			   	sqle.append(" where nopaciente=").append(fieldspValue[i]);
			}
			if(i!=fieldsp.length-1 && !fieldsp[i].equals("nopaciente")) {
				sql.append(",");
			}
		 }
       
		sql.append(sqle);
     
		return jdbcTemplate.update(sql.toString());

	}

	@Override
	public <T> T FindUserName(String userName, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	private class LombokRowMapper<T> implements RowMapper<T>{

		private Class<?> clazz = null;
		
		public LombokRowMapper(Class<?> clazz) {
			super();
			this.clazz = clazz;
		}

		@Override
		public T mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				
				Method builderMethod = clazz.getMethod("builder");
				
				if(builderMethod == null) return null;
				
				Object row = builderMethod.invoke(null);
				
                
				Method[] m = row.getClass().getDeclaredMethods();
				
			
				
                for ( int i=0; i<m.length; i++ ) {
                    	
                	int pos = -1;
                	
                    try { 
                    	
                    	pos = rs.findColumn(  m[i].getName()  );
                     
                     } catch ( SQLException ex ) {  }

                    if ( pos != -1 ) {
                    
                        Object fieldValue = rs.getObject( pos );
                        	
                        m[i].invoke( row, fieldValue );
                        
                    }
                }   
                return  (T) row.getClass().getDeclaredMethod("build").invoke(row);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }	
			return null;
		}
		}
	
   public <T> void getFieldsCustom(T clazz)  {
		
		Fieldsp = clazz.getClass().getDeclaredFields();
		fieldsp = new String [Fieldsp.length-SaveOrUpdate];
		fieldspValue = new Object[Fieldsp.length-SaveOrUpdate];
					
		for(int i=0; i<fieldsp.length ; i++) {
			
			
			fieldsp[i]= Fieldsp[i+SaveOrUpdate].getName();
			
			try {
				fieldspValue[i]=clazz.getClass().
				        getMethod(((Fieldsp[i+SaveOrUpdate].getType().equals(boolean.class))?"is":"get") +
				    		    Fieldsp[i+SaveOrUpdate].getName().substring(0,1).toUpperCase()+Fieldsp[i+SaveOrUpdate].getName().substring(1)).
				                invoke(clazz);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
   
  
	
}
