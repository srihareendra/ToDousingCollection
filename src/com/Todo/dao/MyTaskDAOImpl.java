package com.Todo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.Todo.domain.Task;



public class MyTaskDAOImpl implements TaskDAO {
	

	  public static long cnt=0;
	  
	 public  static List<Task> taskList=new ArrayList<Task>();

	 public synchronized void saveOrUpdateTask(Task task) {
		 task.setId(cnt+1);
		 try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 			taskList.add(task);
	 			cnt=cnt+1;
	 }	 
	 


public synchronized void deleteTask(Long taskId) {
	
	try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Task usr = null;
	if(taskList!=null){
		Iterator<Task> iter = taskList.iterator();
		
		while(iter.hasNext()){
			  usr = (Task) iter.next();
			if(usr.getId().longValue()==taskId.longValue()){
				
				break;
			}
					}
		iter.remove();
		
	}

}


public synchronized List<Task> listTask() {
	System.out.println(" MyUserDAOImpl synchronized listUser...usrList = "+taskList);

	return taskList;
}

 public synchronized Task listTaskById(Long taskId) {
	Task usr = null;
	try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if(taskList!=null){
		Iterator<Task> iter = taskList.iterator();
		
		while(iter.hasNext()){
			  usr = (Task) iter.next();
			if(usr.getId().longValue()==taskId.longValue()){
				break;
				
			}
		}
		iter.remove();
	}
	return usr;
}












}
