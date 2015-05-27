#include <stdio.h>
#include <string.h>
main()
{
   int t,i,c;
   int n,m,sum,index,len;
   int k,f;
   char str[100001];
   while(scanf("%d", &t) != EOF)
      for(i=1;i<=t;i++){
          getchar();
          gets(str);
          scanf("%d", &c);
          len=strlen(str);
          n=len/c;
          m=len%c;
          printf("Case #%d:\n",i);
          for(k=0;k<n;k++){
            	sum=k;
            	index=0;
            	for(f=0;f<c;f++){
            		sum+=index;
            		printf("%c",str[sum]);
            		index=f<m?n+1:n;
                }
          }
          if(m!=0){
            for(f=0;f<m;f++){
                printf("%c",str[n+(n+1)*f]);
            }
           }
            printf("\n");
        }

      }

