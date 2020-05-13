/*
** programmers-�Ҽ�ã��.cpp
** 2020-05-12
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool is_prime_arr[1000001];

void eratos(int n)
{
    /*  ���� n�� 1���� �۰ų� ������ �Լ� ���� */
    if (n <= 1) return;

    /*	2���� n���� n-1���� ������ �� �ִ� �迭 �Ҵ�
		�迭 ���� ��ȣ�� �Ҽ��� ��ġ�ϵ��� �迭�� ũ���
		n+1 ���̸�ŭ �Ҵ�(�ε��� ��ȣ 0�� 1�� ������� ����)	*/

	/*  �迭�ʱ�ȭ: ó���� ��� �Ҽ��� ���� true���� ��	*/
	for (int i = 2; i <= n; i++)
	    is_prime_arr[i] = true;

	/*	�����佺�׳׽��� ü�� �°� �Ҽ��� ����
		����, PrimeArray[i]�� true�̸� i ������ i ����� ����� i��
		������ �ִ� ���� �ǹǷ� i ������ i ����� ���� false���� �ش�.
		PrimeArray[i]�� false�̸� i�� �̹� �Ҽ��� �ƴϹǷ� i�� ��� ����
		�Ҽ��� �ƴϰ� �ȴ�. �׷��Ƿ� �˻��� �ʿ䵵 ����.
���� i*k (k < i) ������ �̹� �˻�Ǿ����Ƿ� j���� ���� i*2 ���� i*i�� ������ �� �ִ�.
	*/
	for (int i = 2; i * i <= n; i++)
	{
		if (is_prime_arr[i])
			for (int j = i * i; j <= n; j += i)
			    is_prime_arr[j] = false;
	}

	// ������ �۾� ...
}

int solution(int n) {
    int answer = 0;
    
   	eratos(n);
   	
   	for(int i=2; i<=n; i++) {
   		if(is_prime_arr[i] == true)	 {
   			answer++;
		}
	}
    
    return answer;
}
