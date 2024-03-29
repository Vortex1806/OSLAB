#include<stdio.h>
struct file{
    char fname[20];
    int start,size,block[10];
}f[10];

int main(){
    int i,j,n;
    printf("Enter the number of files");
    scanf("%d",&n);
    for(i=0;i<n;i++){
        printf("Enter the file name of file %d :",i+1);
        scanf("%s",f[i].fname);
        printf("Enter the starting block %d :",i+1);
        scanf("%d",&f[i].start);
        f[i].block[0]=f[i].start;
        printf("Enter the number of blocks");
        scanf("%d",&f[i].size);
        printf("Enter the blocks occupied");
        for(j=1;j<=f[i].size;j++) scanf("%d",&f[i].block[j]);
    }
    printf("file\tstart\tsize\tblocks");
    for(i=0;i<n;i++){
        printf("\n\t%s\t%d\t%d",f[i].fname,f[i].start,f[i].size);
        for(j=1;j<f[i].size;j++) printf("%d-->",f[i].block[j]);
        printf("%d",f[i].block[j]);
    }
}
