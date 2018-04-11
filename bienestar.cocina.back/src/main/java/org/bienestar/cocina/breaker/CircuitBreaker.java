package org.bienestar.cocina.breaker;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class CircuitBreaker<T extends Sender> implements Runnable{

	private String nombre;
	private Sender sender;
	private Integer errorLimit;
	private Integer timeout;
	private Integer errorCount;
	private Queue<Message> colaMensajes = new ArrayDeque<Message>();
	private String estado = "close";
	
	public CircuitBreaker(String nombre, Sender sender, Integer errorLimit, Integer timeout) {
		super();
		this.nombre = nombre;
		this.sender = sender;
		this.errorLimit = errorLimit;
		this.timeout = timeout;
		this.errorCount = 0;
	}

	public void run() {
		System.out.println("entro hilo");
		while(true){
			if(!colaMensajes.isEmpty()){
				Message message = colaMensajes.poll();
				
				try {
					if("open".equals(estado)){
						System.out.println("esta open");
						addMessage(message);
						continue;
					}
					
					sender.send(message);
					
					if("half".equals(estado)){
						estado = "close";
						System.out.println("pongo estado close");
						errorCount = 0;
					}
				} catch (Exception e) {
					errorCount += 1;
					System.out.println("error count: " + errorCount);
					addMessage(message);
					if(("close".equals(estado) && errorCount >= errorLimit) || "half".equals(estado)){
						estado = "open";
						System.out.println("pongo estado open");
						TimerTask task = new TimerTask() {
							
							@Override
							public void run() {
								estado = "half";
								System.out.println("pongo estado half");
							}
						};
						Timer timer = new Timer();
						timer.schedule(task, timeout);
					}
				}
				
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addMessage(Message message){
		colaMensajes.add(message);
	}
	
	public String getEstado(){
		return estado;
	}

	public String getNombre() {
		return nombre;
	}
}
