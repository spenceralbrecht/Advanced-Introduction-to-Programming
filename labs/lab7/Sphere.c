/* Sphere.c
 * Spencer Albrecht
 * 1488178 (salbrech)
 * lab7
 * Prints out the surface area and volume of sphere
 * */
#include<stdio.h>
#include<math.h>
int main () {
   double radius,volume,surfaceArea;
   const double pi = 3.141592654;
   
   printf("Enter the radius of the sphere: ");
   scanf("%lf", &radius);
   volume = (4.0/3.0)*pi*pow(radius,3);
   surfaceArea = 4.0*pi*pow(radius,2);
   printf("The volume is %f and the surface area is %f.\n", volume, surfaceArea);
   return 0;
}

