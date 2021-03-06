#ifndef _QUEUE_H

typedef struct queue *queue;
typedef struct node *node;
typedef struct node *q_list;

int is_empty(queue q);
queue create_queue(void);
int dispose_queue(queue q);
int en_queue(queue q, char x);
char de_queue(queue q);

#endif

struct queue{
	node front;
	node rear;
//	q_list list;	
};

struct node{
	char element;
	struct node *next;
};
