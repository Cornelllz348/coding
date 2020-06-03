seconds = int(input())

array = []
array.append(seconds // 31536000) # years
array.append((seconds % 31536000) // 86400) # days
array.append(((seconds % 31536000) % 86400) // 3600) # hours
array.append((((seconds % 31536000) % 86400) % 3600) // 60) # minutes
array.append((((seconds % 31536000) % 86400) % 3600) % 60) # seconds

count = 0
plural = []
loc = []
time = [' year', ' day', ' hour', ' minute', ' second']
output = ''

for i in range(5):
    if array[i] > 0:
        count += 1
    if array[i] > 1:
        plural.append('s')
    else:
        plural.append('')
for i in range(5):
    if array[i] > 0 and count > 2:
        loc.append(', ')
        count -= 1
    elif array[i] > 0 and count == 2:
        loc.append(' and ')
        count -= 1
    else:
        loc.append('')
if count == 0:
    output += 'now'
for i in range(5):
    if array[i] > 0:
        output += (str(array[i]) + time[i] + plural[i] + loc[i])