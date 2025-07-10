import random

def miller_rabin(n, k=5):
    if n <= 1 or n == 4:
        return False
    if n <= 3:
        return True
    

    r, d = 0, n - 1
    while d % 2 == 0:
        r += 1
        d //= 2
    
    def try_composite(a):
        if pow(a, d, n) == 1:
            return False
        for i in range(r):
            if pow(a, d * (2 ** i), n) == n - 1:
                return False
        return True
    

    for _ in range(k):
        a = random.randint(2, n - 2)
        if try_composite(a):
            return False
    
    return True

def main():
    num = int(input("Enter the number : "))
    print("Miller-Rabin Primality Test:")
    print(f"{num} is {'probably prime' if miller_rabin(num) else 'composite'}")
    
if __name__ == "__main__":
    main()