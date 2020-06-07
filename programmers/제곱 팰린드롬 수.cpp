/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// cin >> a;                            // int ���� 1�� �Է¹޴� ����
// cin >> b >> c;                       // float ���� 2�� �Է¹޴� ���� 
// cin >> d >> e >> f;                  // double ���� 3�� �Է¹޴� ����
// cin >> g;                            // char ���� 1�� �Է¹޴� ����
// cin >> var;                          // ���ڿ� 1�� �Է¹޴� ����
// cin >> AB;                           // long long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = 'b';
// char var[256] = "ABCDEFG";
// long long AB = 12345678901234567L;
// cout << a;                           // int ���� 1�� ����ϴ� ����
// cout << b << " " << c;               // float ���� 2�� ����ϴ� ����
// cout << d << " " << e << " " << f;   // double ���� 3�� ����ϴ� ����
// cout << g;                           // char ���� 1�� ����ϴ� ����
// cout << var;                         // ���ڿ� 1�� ����ϴ� ����
// cout << AB;                          // long long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>

using namespace std;

bool isPalindrome(int n) {
	
	bool answer = true;
	int numArr[4] = {0,};
	int temp = n;
	int idx = 0;
	int num = 0;
	
	while(temp > 0) {
		numArr[idx++] = temp%10;
		temp /= 10;
	}
	
	for(int i=0; i<idx; i++) {
		if(numArr[i] != numArr[idx-1-i]) {
			return false;
		}
	}
	
	for(int i = n/2; i>0; i--) {
		if(i*i < n) {
			return false;
		}
		
		if(i*i == n) {
			num = i;
			break;
		}
	}
	
	idx = 0;
	for(int i=0; i<4; i++)
		numArr[i] = 0;

	while(num > 0) {
		numArr[idx++] = num%10;
		num /= 10;
	}
	
	for(int i=0; i<idx; i++) {
		if(numArr[i] != numArr[idx-1-i]) {
			return false;
		}
	}
	
	return answer;
} 

int main(int argc, char** argv)
{
   int test_case;
   int T;
   /*
      �Ʒ��� freopen �Լ��� input.txt �� read only �������� �� ��,
      ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
      //�������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
      freopen �Լ��� �̿��ϸ� ���� cin �� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
      ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �Լ��� ����ϼŵ� �����ϴ�.
      freopen �Լ��� ����ϱ� ���ؼ��� #include <cstdio>, Ȥ�� #include <stdio.h> �� �ʿ��մϴ�.
      ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� freopen �Լ��� ����ų� �ּ� ó�� �ϼž� �մϴ�.
   */
   //freopen("input.txt", "r", stdin);
   cin >> T;
   /*
      ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
   */
   for(test_case = 1; test_case <= T; ++test_case)
   {
		int A, B;
		int cnt = 0;
		cin >> A >> B;
		
		for(int i=A; i<=B; i++) {
			if(isPalindrome(i)) {
				cnt++;
			}
		}
		
		cout << "#" << test_case << " " << cnt << endl;
		cnt = 0;
   }
   
   return 0;//��������� �ݵ�� 0�� �����ؾ��մϴ�.
}
