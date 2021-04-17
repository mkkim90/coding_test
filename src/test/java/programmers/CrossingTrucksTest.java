package programmers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 건너는 트럭
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 * <p>
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 */
public class CrossingTrucksTest {

    @Test
    void solution() {
        int[] trucks = {7, 4, 5, 6};
        assertThat(crossingTruck(2, 10, trucks)).isEqualTo(8);
    }

    private int currentBridgeWeight;

    private int crossingTruck(int bridgeLength, int bridgeWeight, int[] truckWeights) {
        Queue<Truck> waitTrucks = new LinkedList<>();
        // 대기 트럭 큐 생성
        createWaitTrucks(truckWeights, waitTrucks);

        // 다리를 지나는 큐 생성
        Queue<Truck> movingTrucks = new LinkedList<>();
        currentBridgeWeight = truckWeights[0];
        movingTrucks.offer(waitTrucks.poll());

        int elpsdTime = 1;
        while (!movingTrucks.isEmpty()) {
            elpsdTime++;
            moving(movingTrucks); // 다리 건너기
            passingTruck(movingTrucks, bridgeLength); // 다리를 지나간 트럭
            addMovingTruck(waitTrucks, movingTrucks, bridgeWeight); // 다리 건너는 트럭 추
        }

        return elpsdTime;
    }

    private void addMovingTruck(Queue<Truck> waitTrucks, Queue<Truck> movingTrucks, int bridgeWeight) {
        if (!waitTrucks.isEmpty() && currentBridgeWeight + waitTrucks.peek().getWeight() <= bridgeWeight) {
            Truck addMovingTruck = waitTrucks.poll();
            movingTrucks.offer(addMovingTruck);
            currentBridgeWeight += addMovingTruck.getWeight();
        }
    }

    private void passingTruck(Queue<Truck> movingTrucks, int bridgeLength) {
        if (movingTrucks.peek().getPoint() >= bridgeLength) {
            Truck removeMovingTruck = movingTrucks.poll();
            currentBridgeWeight -= removeMovingTruck.getWeight();
        }
    }

    private void moving(Queue<Truck> movingTrucks) {
        for (Truck movingTruck : movingTrucks) {
            movingTruck.moving();
        }
    }

    private void createWaitTrucks(int[] trucks, Queue<Truck> waitTrucks) {
        for (int truck : trucks) {
            waitTrucks.offer(new Truck(truck));
        }
    }

    @Test
    void solution2() {
        int[] trucks = {7, 4, 5, 6};
        assertThat(crossingTruck2(2, 10, trucks)).isEqualTo(8);
    }

    private int crossingTruck2(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList<>();
        int time = 0, idx = 0;

        while (idx < truck_weights.length) {
            //트럭이 머무는 시간에 도달 했을 경우
            if (!queue.isEmpty() && time == queue.peek()[1]) {

                int[] truck = queue.poll(); //다리를 지남

                //트럭이 나가서 하중 증가
                weight += truck[0];
            }

            //남은 하중 보다 트럭 하중이 작으면
            if (weight >= truck_weights[idx]) {
                //배열 {진입한 트럭의 무게, 도달시간}
                queue.add(new int[]{truck_weights[idx], time + bridge_length});
                //트럭이 올라가고 남은 하중
                weight -= truck_weights[idx];
                idx++;
            }

            time++;
        }

        return time + bridge_length;

    }
}

class Truck {
    private int weight;
    private int point = 0;

    void moving() {
        point++;
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getPoint() {
        return point;
    }
}