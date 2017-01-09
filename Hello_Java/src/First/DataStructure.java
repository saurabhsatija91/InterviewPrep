package First;

public class DataStructure {
	private final static int SIZE = 10;
	private int[] arrayInt = new int[SIZE];
	
	public DataStructure() {
		for (int i = 0; i < SIZE; i++) {
			arrayInt[i] = i;
		}
	}
	
	public void printEven() {
		DataStructureIterator iterator = this.new EvenIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	//TEST changes
	public void print(DataStructureIterator iterator) {
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	
	public void print(java.util.function.Function<Integer, Boolean> function) {
		for(int i = 0; i < SIZE; i++) {
			if(function.apply(i))
				System.out.print(arrayInt[i]);
		}
		System.out.println();
	}
	
	public int getSize() {
		return SIZE;
	}
	public int get(int index) {
		return arrayInt[index];
	}
	
	public static Boolean isEven(int i) {
		if (i % 2 == 0) return true;
		return false;
	}
	public static Boolean isOdd(int i) {
		if (i % 2 == 1) return true;
		return false;
	}
	
	interface DataStructureIterator extends java.util.Iterator<Integer> {}

	private class EvenIterator implements DataStructureIterator {
		private int nextIndex = 0;
		
		public boolean hasNext() {
			return (nextIndex <= SIZE - 1);
		}
		public Integer next() {
			Integer val = Integer.valueOf(arrayInt[nextIndex]);
			nextIndex +=2;

			return val;
		}
	}
	
	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		//ds.printEven();
		DataStructure.EvenIterator ei = ds.new EvenIterator();
		ds.print(ei);
		
		//Printing odd indices values using anonymous class.
		ds.print(new DataStructure.DataStructureIterator() {
			private int nextIndex = 1;
			@Override
			public Integer next() {
				Integer val = Integer.valueOf(ds.get(nextIndex));
				nextIndex +=2;
				return val;
			}
			
			@Override
			public boolean hasNext() {
				return (nextIndex <= ds.getSize() - 1);
			}
		});
		
		//Using Lambda
		ds.print(index-> {
			if (index % 2 == 0) return true;
			return false;
		});
		
		ds.print(index-> {
			if (index % 2 == 1) return true;
			return false;
		});
		
		System.out.println("Using Method Ref");
		ds.print(DataStructure:: isEven);
		ds.print(DataStructure:: isOdd);
	}

}



