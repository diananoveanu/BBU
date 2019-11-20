//
// Created by Diana on 11/14/2019.
//

#include <iostream>
#include <vector>
#include <chrono>
#include "BigNum.h"
#include "BigNumParal.h"
#include "Helper.h"
#include "numberProd.h"

int main() {
    auto help = Helper();
    std::string pathToA = "/Users/diananoveanu/UBB/Sem5/PDP/Lab6Bonus/num_file_a.txt";
    std::string pathToB = "/Users/diananoveanu/UBB/Sem5/PDP/Lab6Bonus/num_file_b.txt";
    std::vector<int> A = help.readBigFromFile(pathToA);
    std::vector<int> B = help.readBigFromFile(pathToB);

    auto num = BigNum(A);
    auto num1 = BigNum(B);
    double execTime = 0.0;
    auto start = std::chrono::steady_clock::now();

    auto rez = num * num1;
    auto end = std::chrono::steady_clock::now();
    auto diff = end - start;
    auto time = std::chrono::duration<double, std::milli>(diff).count();
    time = time * 0.001;

    std::cout << "Sequential O(n^2) multiplication " << time << '\n';

    rez = mulNumsParallel(num, num1, 1, execTime);
    std::cout << "Parallel O(n^2) multiplication: " << execTime << '\n';
    rez = karatsubaParallel(num, num1, 1, execTime);
    std::cout << "Parallel Karatsuba multiplication: " << execTime << '\n';
    karatsubaSequential(num, num1, execTime);
    std::cout << "Sequential Karatsuba multiplication: " << execTime << '\n';
    std::cout << "Result: " << rez;
    return 0;

}
