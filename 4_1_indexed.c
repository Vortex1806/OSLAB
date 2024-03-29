#include<stdio.h>
int main(){
    int n,m[10],sb[10],s[10],b[10][10],i,j,x;
    printf("Enter the number of files");
    scanf("%d",&n);
    for(i=0;i<n;i++){
        printf("Enter the starting block and file size of file %d :",(i+1));
        scanf("%d%d",&sb[i],&s[i]);
        printf("Enter the number of blocks of file %d :",(i+1));
        scanf("%d",&m[i]);
        printf("Enter the blocks occupied by file %d :",(i+1));
        for( j=0;j<m[i];j++) scanf("%d",&b[i][j]);
    }
    printf("\nFile\tindex\tlength");
    for(i=0;i<n;i++){
        printf("\n%d\t%d\t%d",i+1,sb[i],m[i]);
    }
    printf("Enter the file name");
    scanf("%d",&x);
    i=x-1;
    printf("File name :%d\nStarting block :%d\nFile size :%d",x,sb[i],s[i]);
    printf("\nBLocks occupied are:");
    for(j=0;j<m[i];j++) printf("%d\t",b[i][j]);
    return 0;
}
