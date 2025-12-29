public class TestBox {
	
	public static void main(String args[]){
		Box<Integer> integerBox = new Box<>();
		
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String> p2 = new OrderedPair<String, String>("Hello", "World");
		
		System.out.println(p1.getKey());
		System.out.println(p1.getValue());
		
		System.out.println(p2.getKey());
		System.out.println(p2.getValue());
	}

}