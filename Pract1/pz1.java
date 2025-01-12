// Підрахунок середнього значення елементів масиву
float average(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }
    return sum / (float)n;
}


int s;  //Поганий приклад: що таке "s"?

int total_sum;  //Гарний приклад: зрозуміло, що змінна зберігає суму


if (condition) {
statement;
}


printf("Start program\n");

// Ініціалізація
int a = 5;
int b = 10;

// Виклик функції
int result = add_numbers(a, b);




void process(int a, int b) {
    int result = a + b;   // Додавання чисел
    printf("Result: %d\n", result);   // Друк результату
}


int add_numbers(int a, int b) {
    return a + b;
}

void print_result(int result) {
    printf("Result: %d\n", result);
}




if (x > 0) printf("Positive\n"); // Відсутня фігурна дужка


if (x > 0) {
printf("Positive\n");
} else {
printf("Non-positive\n");
}


int max(int a,int b){if(a>b)return a;else return b;}



int max(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

├── main.c
├── utils.c
└── utils.h

