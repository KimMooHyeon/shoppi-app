package screen

sealed class Screen
object ScreenStack {
    private val screenStack = mutableListOf<Screen>()
    fun push(screen: Screen) {
        screenStack.add(screen)
    }

    fun pop(){
        screenStack.removeLastOrNull()
    }
    fun peek(): Screen?{
        return screenStack.lastOrNull()
    }

}


