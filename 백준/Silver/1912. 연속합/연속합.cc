#include <iostream>
#include <algorithm>
using namespace std;

int input[100001] = {
    0,
};
int dp[100001] = {
    0,
};

int main()
{
    int N;
    long long ans;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> input[i];
        dp[i] = input[i];
    }

    ans = dp[0];
    for (int i = 0; i < N; i++)
    {
        dp[i] = max(dp[i - 1] + input[i], dp[i]);

        if (ans < dp[i])
            ans = dp[i];
    }

    cout << ans << endl;
    return 0;
}