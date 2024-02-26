package functionPointers;


public class functptr {
	
	public interface functionPTR {
		public int func(int a, int b);
		public String getOPname();
	}
	

	public enum ops {
		add,
		sub,
	};
	
	static functionPTR fp[] = { 
			new functionPTR() {
				public int func(int a, int b) {
					return a+b;
				}
				public String getOPname() { return "+"; }
			},
				
			new functionPTR() {
				public int func(int a, int b) {
					return a-b;
				}
				public String getOPname() { return "-"; }
			}
		
		};
	
	
	
	public static void main(String[] args) {
		
		Op operations[] = {
				new Op(1,2,fp[ops.add.ordinal()]),
				new Op(7,2,fp[ops.sub.ordinal()]),
				new Op(90,-9,fp[ops.add.ordinal()]),
				new Op(945,92,fp[ops.sub.ordinal()]),
				new Op(5,-82,fp[ops.sub.ordinal()]),
		};
		
		for (Op operation : operations) {
			System.out.println(operation.a+ " " + operation.func.getOPname()+ " "+ operation.b + " = " 
					+ operation.func.func(operation.a, operation.b));
		}
	}

}


class Op{
	
	public int a;
	public int b;
	public functptr.functionPTR func;
	
	Op(int a, int b, functptr.functionPTR func){
		this.a = a;
		this.b = b;
		this.func = func;
	}
}