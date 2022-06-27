#include<stdio.h>
#include<stdlib.h>
int main(){
    char s1[]= "2+3/4*5+2.5*3";
    // show result of the expression
    printf("%f\n",eval(s1));
    return 0;
}