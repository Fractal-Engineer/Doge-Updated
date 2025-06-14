from ursina import *
from ursina.prefabs.first_person_controller import FirstPersonController

app = Ursina()
player = FirstPersonController()

doge_textures = ['XSimBK.png', 'R__1.png', 'OIP__1.png', 'Oh_Wow_So_Doge_The_Meme_Of_Day_Trigger_Plug.png']
sky_textures = ['Doge In Space Wallpaper.jpg', 'basically-heaven.jpg']

current_block_index = 0
current_sky_index = 0

skybox_image = load_texture(sky_textures[current_sky_index])
sky = Sky(texture=skybox_image)

boxes = []
for i in range(20):
    for j in range(20):
        box = Button(color=color.white, model='cube', position=(j, 0, i),
                     texture=doge_textures[0], parent=scene, origin_y=0.5)
        boxes.append(box)

def input(key):
    global current_block_index, current_sky_index, sky

    if key == 't':
        current_block_index = (current_block_index + 1) % len(doge_textures)
        print(f"Block texture: {doge_textures[current_block_index]}")

    if key == 'n':
        current_sky_index = (current_sky_index + 1) % len(sky_textures)
        sky.texture = load_texture(sky_textures[current_sky_index])
        print(f"Sky texture: {sky_textures[current_sky_index]}")

    for box in boxes:
        if box.hovered:
            if key == 'left mouse down':
                new = Button(
                    color=color.white,
                    model='cube',
                    position=box.position + mouse.normal,
                    texture=doge_textures[current_block_index],
                    parent=scene,
                    origin_y=0.5
                )
                boxes.append(new)
            elif key == 'right mouse down':
                boxes.remove(box)
                destroy(box)

app.run()