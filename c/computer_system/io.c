#include<unistd.h>
#include<fcntl.h>
#include<sys/types.h>
void echo()
{
    char c;
    while(read(STDIN_FILENO,&c,1)!=0)
        write(STDOUT_FILENO,&c,1);
}
ssize_t rio_readn(int fd,void *usrbuf,size_t n)
{
    size_t nleft=n;
    ssize_t nread;
    char *bufp=usrbuf;
    while(nleft>0){
        if((nread=read(fd,bufp,nleft))<0){//error occur
            if(errno==EINTR)
                nread=0;
            else
                return -1;
        }
        else if(nread==0)//EOF
            break;
        nleft-=nread;
        bufp+=nread;
    }
    return (n-nleft);
}
ssize_t rio_writen(int fd,void *usrbuf,size_t n)
{
    size_t nleft=n;
    ssize_t nwrite;
    char *bufp=usrbuf;

    while(nleft>0){
        if((nwrite=write(fd,bufp,nleft))<=0){
            if(errno==EINTR)
                nwrite=0;
            else
                return -1;
        }
        nleft-=nwrite;
        bufp+=nwrite;
    }
    return n;
}
void rio_readinitb(rio_t *rp,int fd)
{
    rp->rio_fd=fd;
    rp->rio_cnt=0;
    rp->rio_bufptr=rp->rio_buf;
}

int main()
{
    //echo();
    int n;

}
