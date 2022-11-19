arr = [[60,10],[100,20],[120,30]]
w = 50
price = 0

arr = sorted(arr, key = lambda x : x[0] / x[1], reverse = True)

for i in range(len(arr)):
	if(arr[i][1] > w):
		price += (arr[i][1] -(arr[i][1]-w))*(arr[i][0] / arr[i][1])
	else:
		price += arr[i][0]	
		w -= arr[i][1]

print(price)
