#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/stat.h>

int main(int argc,char **argv)
{
    struct stat st;
    char *type,*readok;
    if(stat(argv[1],&st)==-1)
        exit(-1);
    if(S_ISREG(st.st_mode))
        type="regular";
    else if(S_ISDIR(st.st_mode))
        type="dir";
    else
        type="other";
    if((st.st_mode&S_IRUSR))
        readok="yes";
    else
        readok="no";
    printf("type:%s,read:%s\n",type,readok);
    return 0;
}
