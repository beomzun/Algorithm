#include<iostream>
#include<vector>
#include<queue>

using namespace std;

vector<pair<pair<int, int>, int>> list[1001][1001];
int check[1001][1001][2];

int main(){

    int n,m;
    cin >> n >> m;

    int map[n+1][m+1];

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {

            if(i+1<=n && map[i+1][j]==0) list[i][j].push_back({{i+1, j},0});
            if(i-1>=1 && map[i-1][j]==0) list[i][j].push_back({{i-1, j},0});
            if(j+1<=m && map[i][j+1]==0) list[i][j].push_back({{i, j+1},0});
            if(j-1>=1 && map[i][j-1]==0) list[i][j].push_back({{i, j-1},0});

            if(i+1<=n && map[i+1][j]==1) list[i][j].push_back({{i+1, j},1});
            if(i-1>=1 && map[i-1][j]==1) list[i][j].push_back({{i-1, j},1});
            if(j+1<=m && map[i][j+1]==1) list[i][j].push_back({{i, j+1},1});
            if(j-1>=1 && map[i][j-1]==1) list[i][j].push_back({{i, j-1},1});
        }
    }

    queue<pair<pair<int, int>, int>> q;
    q.push({{1,1},0});
    check[1][1][0] = 1;
    check[1][1][1] = 0;

    int min = -1;

    while(!q.empty()){
        pair<pair<int, int>,int> f = q.front();
        q.pop();

        pair<int, int> to = f.first;

        if(n==1 && m==1) {
            min = 1;
            break;
        }

        for(int i=0; i<list[to.first][to.second].size(); i++) {
            pair<int, int> x = list[to.first][to.second][i].first;
            int y = list[to.first][to.second][i].second;

            if(x.first ==n && x.second==m) {
                if(min==-1 || check[to.first][to.second][0]+1<min)
                min = check[to.first][to.second][0]+1;
            } else {
                if(check[to.first][to.second][1]+y <= 1){
                    if(check[x.first][x.second][0]==0 || (check[to.first][to.second][1]==0 && check[x.first][x.second][1]>0)){
                        q.push({x,y});
                        check[x.first][x.second][0] = check[to.first][to.second][0]+1;
                        check[x.first][x.second][1] = check[to.first][to.second][1]+y;
                        }
                    
                    }
            } 
        }
    }

    cout << min << '\n';

}