#include<iostream>
using namespace std;
// //Recursive
// int rec( int n){
//         if(n<=1){
//             return n;
//         }
//         return rec(n-1)+rec(n-2);
// }

int main()
{
    int num;
    cout<<"Enter number : ";
    cin>>num;
    int a = 0 , b = 1 ,c;
    cout<<"Fibonacci Series is: ";
    cout<<a<<" "<<b<<" ";
    // Non Recursive
    for(int i = 2; i<num ;i++){
        c = a + b;
        cout<<c<<" ";
        a = b;
        b = c;
    }
    cout<<"\n"<<"Fibonacci Number is : "<<c;
    // cout<<"Fibonacci Number is : "<<rec(num-1)<<endl;
    // cout<<"Fibonacci Series is : ";
    // for(int i=0;i<num;i++){
    //     cout<<rec(i)<<" ";
    // }
}
