import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 남여  둘 중 팀 생성에 최소값을 갖는 성별을 찾는다.
    // 이 기준으로 남여의 수를 줄이고 인턴 수와 비교한다. -> 전체 인원이 클시 통과
    // 전체 인원이 작을시 2대 1 비율로 인원을 줄여 나가고. 팀을 해체한다.

    var (girl, boy, intern) = readLine().split(" ").map { it.toInt() }

    val minIsGirl = girl < boy * 2
    val restGirl = if (minIsGirl) 0 else girl - boy * 2
    val restBoy = if (minIsGirl) boy - girl / 2 else 0

    var maxTeamNum = if (minIsGirl) girl /2 else boy

    intern -= (restGirl + restBoy)

    while (intern > 0) {
        maxTeamNum--
        intern -= 3
    }

    println(maxTeamNum)
}


// println(Math.min(Math.min(n/2,m),(n+m-k)/3))
