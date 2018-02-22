package com.github.thiwanka92;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MysqlBackUpApp {
	public static void main(String[] args) {
	//  NOTE: Date format
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	
	//  NOTE: Creating Database Constraints
		String dbHost = "localhost"; //host server IP
		String dbPort = "3306";
        String dbName = "testDb";
        String dbUser = "root";
        String dbPass = "abc@123";
        String dumpExe = "C:\\programFile\\wamp64\\bin\\mysql\\mysql5.7.14\\bin\\mysqldump";
   //   NOTE: Here the backup folder is for saving inside it
        String dumpSavePath = "D:\\BackupFolder\\";
   //   NOTE: Here the backup is saved in a folder called backup with the name backup.sql
        String fileName = "backUpFile_"+sdf.format(new Date().getTime())+".sql";
        
   //   NOTE : call for backup process
        Backupdbtosql(dbHost, dbPort, dbUser, dbPass, dbName, dumpExe, dumpSavePath, fileName);
	}
	
	public static void Backupdbtosql(String host,String port,String user,String password,String dbName,String dumpExe,String dumpSavePath,String fileName) {
	    try {
	    //  NOTE: Date format
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	        String batchCommand;
	        if (password != "") {
		         //only backup the data not included create database
		         batchCommand = dumpExe + 
		        		 " -h " + host + 
		        		 " --port " + port + 
		        		 " -u " + user + 
		        		 " --password=" + password + 
		        		 " --add-drop-database -B " + dbName + 
		        		 " -r \"" + dumpSavePath + "" + "backup"+new Date().getTime()+".sql";
	        } else {
	        	 batchCommand = dumpExe + 
	        			 " -h " + host + 
	        			 " --port " + "3306" + 
	        			 " -u " + user + 
	        			 " --add-drop-database -B " + dbName + 
	        			 " -r \"" + dumpSavePath + "" + "backup"+new Date().getTime()+".sql";
	        }
	         
	 //     NOTE: Executing the command here
	        System.out.println("Execute Commond - " +batchCommand);
	        System.out.println("Processing.. "+ "STARTED " +sdf.format(new Date()));
	        Date sDate = new Date();
	        Process runtimeProcess = Runtime.getRuntime().exec(batchCommand);
	        int processComplete = runtimeProcess.waitFor();
	        
	        System.out.println("Processing.. "+ "END " +sdf.format(new Date()));
	        Date eDate = new Date();
	        long duration =  eDate.getTime() - sDate.getTime();
	        int seconds=(int) ((duration/1000)%60);
	        long minutes=((duration-seconds)/1000)/60;
	        System.err.println("TOTAL TIME : " + minutes +" minutes :: ");
	        System.err.print(seconds +" seconds :: ");
	        System.err.print(duration +" milliseconds");

	//      NOTE: processComplete=0 if correctly executed, will contain other values if not
	        if (processComplete == 0) {
	            System.out.println("Backup Complete");
	        } else {
	            System.out.println("Backup Failure");
	        }

	    } catch (Exception ex) {
	    	System.err.println(ex.getMessage());
	    }
	}
}
