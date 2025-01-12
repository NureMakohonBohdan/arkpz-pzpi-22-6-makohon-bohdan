void process_data(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }
    printf("Sum: %d\n", sum);
    printf("Average: %.2f\n", sum / (float)n);
}


int calculate_sum(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }
    return sum;
}

void print_statistics(int arr[], int n) {
    int sum = calculate_sum(arr, n);
    printf("Sum: %d\n", sum);
    printf("Average: %.2f\n", sum / (float)n);
}


int f(int a, int b) {
    return a * b;
}



int multiply(int a, int b) {
    return a * b;
}


if (age >= 18 && has_license == 1 && !is_suspended) {
printf("Allowed to drive.\n");
}




bool can_drive(int age, int has_license, int is_suspended) {
    return age >= 18 && has_license && !is_suspended;
}

if (can_drive(age, has_license, is_suspended)) {
printf("Allowed to drive.\n");
}


