//-----------------------------------------------------------------------------
//   Complex.java
//   Spencer Albrecht
//   1488178
//   Programming Assignment 6
//   Represents complex numbers as a pair of doubles
//-----------------------------------------------------------------------------

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields
   //--------------------------------------------------------------------------
   private double re;
   private double im;

   //--------------------------------------------------------------------------
   // Public Constant Fields
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      re = a;
      im = b;
   }

   Complex(double a){
      re = a;
      im = 0;
   }

   Complex(String s){
      // Fill in this constructor.
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
      double[] complexArray = new double[2];
      complexArray = parseComplex(s);
      re = complexArray[0];
      im = complexArray[1];
   }

   //---------------------------------------------------------------------------
   // Public methods
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
      Complex copy = new Complex(re, im);
      return copy;
   }

   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      double nr, ni;
      nr = re + z.Re();
      ni = im + z.Im();
      Complex newComplex = new Complex(nr, ni);
      return newComplex;
   }

   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      double nr, ni;
      nr = re;
      ni = im;
      nr*=-1;
      ni*=-1;
      Complex newComplex = new Complex(nr, ni);
      return newComplex;
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      double nr, ni;
      nr = re - z.Re();
      ni = im - z.Im();
      Complex newComplex = new Complex(nr, ni);
      return newComplex;
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
     double nr, ni;
     nr = ((re*z.Re())-(im*z.Im()));
     ni = ((re*z.Im())+(im*z.Re()));
     Complex newComplex = new Complex(nr, ni);
     return newComplex;
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if
   // this.equals(Complex.ZERO).
   Complex recip(){
      if (this.equals(Complex.ZERO)) {
        ArithmeticException e = new ArithmeticException();
        throw e;
      }
      double nr, ni;
      nr = (re/((re*re)+(im*im)));
      ni = (im*=-1)/((re*re)+(im*im));
      Complex newComplex = new Complex(nr, ni);
      return newComplex;
   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
     if (z.equals(Complex.ZERO)) {
       ArithmeticException e = new ArithmeticException();
       throw e;
     }
     double nr, ni;
     nr = ((this.re*z.Re())+(this.im*z.Im()))/((z.re*z.re)+(z.im*z.im));
     ni = ((z.Re()*this.Im())-(z.Im()*this.re))/((z.re*z.re)+(z.im*z.im));
     System.out.println("New real:"+nr+"New imag:"+ni);
     Complex newComplex = new Complex(nr, ni);
     System.out.println(newComplex);
     return newComplex;
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
     double ni;
     ni = im*=-1;
     Complex newComplex = new Complex(re, ni);
     return newComplex;
   }

   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between
   // points (0, 0) and (re, im).
   double abs(){
      double absVal = Math.sqrt((re*re)+(im*im));
      return absVal;
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------

   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      if (im == 0) {
        return re+"";
      }
      else if (re == 0) {
        return im+"i";
      }
      else if (im > 0) {
        return re+"+"+im+"i";
      }
      else {
        return String.valueOf(re)+String.valueOf(im)+"i";
      }
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      // Fill in
      Complex newObj;
      newObj = (Complex) obj;
      if (re == newObj.Re() & im == newObj.Im()) {
        return true;
      }
      else {
        return false;
      }
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      Complex newComplex = new Complex(a,b);
      return newComplex;
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
     Complex newComplex = new Complex(a);
     return newComplex;
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
     Complex newComplex = new Complex(s);
     return newComplex;
   }

   // parseComplex()
   // Returns a double[] of length 2 containing (real, imaginary) parts
   // of a complex number represented by string argument str.  Throws a
   // NumberFormatException if str cannot be parsed as a complex number.
   static double[] parseComplex(String str){
      double[] part = new double[2];
      String s = str.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;

      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I)
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
   }

}
