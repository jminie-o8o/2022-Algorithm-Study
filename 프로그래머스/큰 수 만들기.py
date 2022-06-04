def solution(number, k):
    number_list = list(number)
    stack = []
    for number in number_list:
        while stack and stack[-1] < number and k > 0:
            stack.pop()
            k -= 1
        stack.append(number)
    if k > 0:
        stack = stack[:-k]
    answer = ''.join(stack)
    return answer