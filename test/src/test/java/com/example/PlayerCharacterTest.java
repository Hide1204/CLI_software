public class PlayerCharacterTest {

    @Test
    public void 右へ移動() {
        PlayerCharacter PC= new PlayerCharacter(10,10);
        PC.moveRight();
        assertEquals(11, PC.get_x());
    }
}