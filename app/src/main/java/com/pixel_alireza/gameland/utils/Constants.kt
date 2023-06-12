package com.pixel_alireza.gameland.utils


object Constants {
    const val NORMAL_BASE_URL = "http://gate.dunijet2.com:8080"
    const val WS_BASE_URL = "ws://gate.holosen.xyz:8080"
    const val CLOSE =
        "r(xGtm7JIG2xf3EB9*IwRn)RTW4*QnHn^pQ)*XKLHXJUX*)P^9kJAccQvY9+X!fcloseSessionp&2G7*JknwGR@Ihurr(xGtm7JIG2xf3EB9*IwRn)RTW4*QnHn^pQ)*XKLHXJUX*)P^9kJAccQvY9+X!fr(xGtm7JIG2xf3EB9*IwRn)RTW4*QnHn^pQ)*XKLHXJUX*)P^9kJAccQvY9+X!f(xGtm7JIG2xf3EB9*IwRn)RTW4*QnHn^pQ)*XKLHXJUX*)P^9kJAccQvY9+X!f"
}

sealed class ChatState(val state: String) {
    object CONNECTED : ChatState(state = "GameLand")
    object DISCONNECTED : ChatState(state = "Connecting...")
    object NETWORK_UNAVALABLE : ChatState(state = "Waiting for network...")
}

object GameNames {
    const val CODM = "CALL OF DUTY MOBILE"
    const val FREEFIRE = "FREEFIRE"
    const val PUBGMOBILE = "PUBG MOBILE"
    const val ClashOfClans = "Clash Of Clans"
    const val ClashRoyal = "Clash Royal"
}