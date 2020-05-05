import re
# https://www.w3schools.com/python/python_regex.asp
# solution 4553250

# e.g. change BC to 55
def stox(s):
    x = 0
    for c in s:
        x = x * 26 + (ord(c) - ord('A') + 1)
    return x

# e.g. change 55 to BC
def xtos(x):
    s = ''
    while x != 0:
        x -= 1
        s = chr(x % 26 + ord('A')) + s
        x // 26
    return s

n = int(input())
for i in range(n):
    s = input()
    m = re.match('R(\d+)C(\d+)', s)
    if m is not None:
        print('%s%s' % (xtos(int(m.group(2))), m.group(1)))
    else:
        m = re.match('([A-Z]+)(\d+)', s)
        print('R%dC%d' % (int(m.group(2)), stox(m.group(1))))