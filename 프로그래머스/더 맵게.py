import heapq

def solution(scoville, K):
    scoville.sort()
    heapq.heapify(scoville)
    answer = 0
    try:
        while scoville[0] < K:
            a=heapq.heappop(scoville)
            b=heapq.heappop(scoville)
            heapq.heappush(scoville, a + b * 2)
            answer += 1
    except:
        answer = -1

    return answer