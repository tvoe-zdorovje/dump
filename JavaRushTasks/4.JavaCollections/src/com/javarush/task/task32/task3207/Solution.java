package com.javarush.task.task32.task3207;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {

        	try {

        		DoubleString doubleString = (DoubleString)
        		registry.lookup(UNIC_BINDING_NAME);

		        System.out.println(doubleString.doubleString("pidor"));

	        }catch (RemoteException e){
        		e.printStackTrace();
	        }catch (NotBoundException e){
		        e.printStackTrace();
	        }

        }
    });

    public static void main(String[] args) throws InterruptedException, NoSuchObjectException {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
            final DoubleStringImpl service = new DoubleStringImpl();
        try {
            registry = LocateRegistry.createRegistry(2099);

            stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
        Thread.sleep(10);
        CLIENT_THREAD.join();
        UnicastRemoteObject.unexportObject(service, false);
    }
}