import java.util.ArrayList;

class Buffer {
	private ArrayList<Integer> list = new ArrayList<>(); // common buffer
	private final int capacity;

	public Buffer(int capacity) {
		this.capacity = capacity;
	}

	public void add(int item, int producerId) {
		if (list.size() < capacity) {
		   System.out.println("Producer " + producerId + " adding item " + item);
		   list.add(item);
		   System.out.println("ITEM COUNT :: " + list.size());
		  }

		/*
		System.out.println("Producer " + producerId + " adding item " + item);
		list.add(item);
		System.out.println("ITEM COUNT :: " + list.size());
		*/

	}

	public void remove(int consumerId) {

		/*
		System.out.println("Consumer " + consumerId + " removing item " + list.get(0));
		list.remove(0);
		System.out.println("ITEM COUNT :: " + list.size());

		*/

		if (!list.isEmpty()) {
   	System.out.println("Consumer " + consumerId + " removing item " + list.get(0));
   	list.remove(0);
   	System.out.println("ITEM COUNT :: " + list.size());
  	}


	}
}

class Producer extends Thread {
	private final Buffer buffer;
	private final int id;

	public Producer(Buffer buffer, int id) {
		this.buffer = buffer;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				this.buffer.add(i, this.id);
				sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}

class Consumer extends Thread {
	private final Buffer buffer;
	private final int id;

	public Consumer(Buffer buffer, int id) {
		this.buffer = buffer;
		this.id = id;
	}

	@Override
	public void run() {
		while (true)
			try {
				this.buffer.remove(this.id);
				sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}

public class Main {
	public static void main(String[] args) {
		Buffer b = new Buffer(5);
		Producer p1 = new Producer(b, 1);
		Consumer c1 = new Consumer(b, 1);
		Consumer c2 = new Consumer(b, 2);
		p1.start();
		c1.start();
		c2.start();
	}
}
