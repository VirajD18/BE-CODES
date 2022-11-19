#include<iostream>
using namespace std;
int main()
{
    int capacity = 10;
    int NoOfItems = 4;
    int value [NoOfItems + 1] = {0, 4,6,2,8};
    int weight [NoOfItems + 1] = {0, 2,2,4,3};
    int dp[NoOfItems + 1][capacity + 1];

    for (int i = 0; i <= NoOfItems; i++){
        for (int j = 0; j<=capacity; j++){
            if(i == 0 || j ==0){
                dp[i][j] = 0;
            }
            else if(weight[i] <= j){
                dp[i][j] = max(dp[i-1][j] , value[i] + dp[i-1][j-weight[i]]);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    cout<<"Max Profit is : "<<dp[NoOfItems][capacity];
    return 0;
}
