package contents;

public class TiposPrimitivos {
	
	// Numeric Types
	byte number1 = (byte) 10;
	short number2 = (short) 10;
	int number3 = 10;
	long number4 = 10L;
	float number5 = 10.0F ;
	double number6 = 10.0;
	
	// Character Types
	char character = 'M';

	// Boolean Types
	boolean trueorfalse = false;
	
	public TiposPrimitivos() {
	}

	public TiposPrimitivos( byte number1, short number2, int number3, long number4, float number5,
							double number6,	char character, boolean trueorfalse) {
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.number6 = number6;
		this.character = character;
		this.trueorfalse = trueorfalse;
	}
	
	
}