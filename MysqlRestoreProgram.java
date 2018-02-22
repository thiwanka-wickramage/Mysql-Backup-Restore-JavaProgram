package com.github.thiwanka92;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MysqlRestoreProgram {
	
	public static void main(String[] args) {
		String mysqlPath 	= "C:\\...\\bin\\mysql\\mysql..\\bin\\mysql ";
		String dbUser 		= "root";
		String dbPassword 	= "";
		String backupFile 	= "D:\\..\\backup1519192425842.sql";
		
		restoreDatabase(mysqlPath,dbUser, dbPassword, backupFile);
	}
	
	public static void restoreDatabase(String mysqlExe,String dbUserName, String dbPassword, String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String[] executeCmd = new String[]{mysqlExe, "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source};
 
        Process runtimeProcess;
        try {
	        System.out.println("Processing.. "+ "STARTED " +sdf.format(new Date()));
	        Date sDate = new Date();
	        
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = 0;
			try {
				processComplete = runtimeProcess.waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            System.out.println("Processing.. "+ "END " +sdf.format(new Date()));
	        Date eDate = new Date();
	        long duration =  eDate.getTime() - sDate.getTime();
	        int seconds=(int) ((duration/1000)%60);
	        long minutes=((duration-seconds)/1000)/60;
	        System.err.println("TOTAL TIME : " + minutes +" minutes :: ");
	        System.err.print(seconds +" seconds :: ");
	        System.err.print(duration +" milliseconds");
	        
            if (processComplete == 0) {
                System.out.println("Backup restored successfully with " + source);
            } else {
            	System.out.println("Could not restore the backup " + source);
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
