def solution(n, lost, reserve):
    answer = n
    death = []
    lost.sort()
    reserve.sort()
    for i in lost:
        for j in reserve:
            if i == j:
                death.append(i)
    for i in death:
        lost.remove(i)
        reserve.remove(i)

    for i in lost:
        if i - 1 in reserve:
            reserve.remove(i - 1)
            continue
        elif i + 1 in reserve:
            reserve.remove(i + 1)
            continue
        else:
            answer -= 1

    return answer