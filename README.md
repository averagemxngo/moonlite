Moonlite is a modern Minecraft hub server solution that is based on DeluxeHub by ItsLewizz.
It contains almost all of its features and configuration files are almost the same, so you can just
drop your configuration into the plugin's directory, make a few modifications and use it.

The main difference between Moonlite and DeluxeHub is that Akropolis uses more modern technologies, like MiniMessage,
the Paper API and updated Java versions. While this give us some performance and usability benefits, it also means
that we won't be giving support to older versions of Minecraft and other Minecraft server software that isn't derivated
from Paper, which is not the case of DeluxeHub.
Simply use what you feel meets your needs.

## How to

### Install

To use this plugin just a grab a binary from the [Modrinth](https://modrinth.com/project/moonlite)
or [compile it](#compile) yourself and drop it into your `plugins/` directory. Take in mind that you will need to be
running Paper 1.21+ so Moonlite can run properly. You can download Paper from [here](https://papermc.io/downloads).

### Compile

Compiling Moonlite is pretty simple, just one command, and you're ready to go:

**Linux (and other UNIX derivatives):**

```bash
./gradlew shadowJar
```

**Windows:**

```batch
gradlew.bat shadowJar
```

Then you will find the binary under the `build/libs/` directory.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for
details.
