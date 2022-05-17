import heapq

def solution(operations):
    heap = []
    answer = []
    for operation in operations:
        if operation.startswith('I'):
            heapq.heappush(heap, int(operation.split()[1]))
        elif len(heap) == 0:
            continue
        else:
            if (operation.split()[0] == 'D') and (operation.split()[1] == '1'):
                heap = heapq.nlargest(len(heap), heap)[1:]
                heapq.heapify(heap)
            elif (operation.split()[0] == 'D') and (operation.split()[1] == '-1'):
                heapq.heappop(heap)
    if len(heap) == 0:
        return [0, 0]
    else:
        return [heapq.nlargest(1, heap)[0], heap[0]]