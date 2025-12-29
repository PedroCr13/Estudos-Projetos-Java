class LambdaExceptionDemo {
	public static void main(String args[]){
		double[] values = {1.0, 2.0, 3.0, 4.0};
		
		MyIOAction myio = (rdr) -> {
			int ch = rdr.read(); //pode lançar IOException
			//...
			return true;
		};
	}
}