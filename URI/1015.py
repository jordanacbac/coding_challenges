p1 = str(input()).split()
p2 = str(input()).split()
p1[0] = float(p1[0])
p1[1] = float(p1[1])
p2[0] = float(p2[0])
p2[1] = float(p2[1])

result = ((p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)**0.5
result = round(result, 4)
print(result)
