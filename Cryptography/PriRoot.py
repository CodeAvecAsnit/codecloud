def totient(n):

    result = n
    p = 2
    while p * p <= n:
        if n % p == 0:
            while n % p == 0:
                n //= p
            result *= (1 - 1/p)
        p += 1
    
    if n > 1:
        result *= (1 - 1/n)
    
    return int(result)


print("\nTotient Function:")
totient_numbers = [10, 11, 12, 13]
for num in totient_numbers:
  print(f"φ({num}) = {totient(num)}")