package ClassAndObj;

public class ComplexNumber {


    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(10, 5);
        ComplexNumber b = new ComplexNumber(2, 3);
        ComplexNumber c1 = a.add(b);
        System.out.println(c1);
    }

    float real, imaginary;

    // Define constructor here
    public ComplexNumber(float r, float i){
        this.real = r;
        this.imaginary = i;
    }


    ComplexNumber add(ComplexNumber x){
        // Complete the function
        return new ComplexNumber((this.real+x.real), (this.imaginary+x.imaginary));
    }

    ComplexNumber subtract(ComplexNumber x){
// Complete the function
        return new ComplexNumber( this.real - x.real ,this.imaginary - x.imaginary);
    }
    ComplexNumber multiply(ComplexNumber x){
// Complete the function
        float r = x.real * this.real - x.imaginary * this.imaginary;
        float i = this.imaginary * x.real + this.real * x.imaginary;
        return new ComplexNumber(r, i);
    }
    ComplexNumber divide(ComplexNumber x){
        float r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        float i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        return new ComplexNumber(r, i);
    }
}

/*
    ComplexNumber a = new ComplexNumber(10, 5)
	ComplexNumber b = new ComplexNumber(2, 3)
	ComplexNumber c1 = a.add(b)
	ComplexNumber c2 = a.subtract(b)
	ComplexNumber c3 = a.multiply(b)
	ComplexNumber c4 = a.divide(b)

*/