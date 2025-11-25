# DropPrevention

A plugin for Minecraft servers based on Spigot/Bukkit that allows players to control the ability to drop items.

## Description

DropPrevention is a simple and convenient plugin that gives players the ability to enable and disable the item drop function. When drop is disabled, the player will not be able to drop items from their inventory (if there is free space).

## Features

- ✅ Enable/disable item drop for each player individually
- ✅ Simple `/drop` command for management
- ✅ Save settings between server restarts
- ✅ Customizable messages through localization file
- ✅ Support for API version 1.8+

## Installation

1. Download the latest version of the plugin from the [Releases](https://github.com/ryzzi00/DropPrevention/releases) section
2. Place the `DropPrevention.jar` file in the `plugins` folder of your server
3. Restart the server
4. The plugin will automatically create the necessary configuration files

## Usage

### Commands

- `/drop` - Toggle drop state (enable/disable)
- `/drop on` - Enable item drop
- `/drop off` - Disable item drop
- `/drop reloadLanguage` - Reload localization file (requires `drop.admin` permission)

### Permissions

- `drop.admin` - Access to localization reload command (default only for OP)

## Configuration

After the first launch, the plugin will create the following files:

### `lang.yml`

File with customizable plugin messages:

```yaml
drop_on: "[DropPrevention] §aDrop enabled"
drop_off: "[DropPrevention] §cDrop disabled"
drop_usage: "[DropPrevention] §cUse /drop - to quickly toggle mode, /drop on to enable or /drop off to disable"
no_permission: "[DropPrevention] §cYou don't have permission for this command"
```

### `storage.json`

File for storing player settings (created automatically, no editing required).

## Requirements

- Minecraft server based on Spigot/Bukkit
- API version: 1.8+
- Java 8 or higher

## Building from Source

If you want to build the plugin yourself:

```bash
git clone https://github.com/ryzzi00/DropPrevention.git
cd DropPrevention
./gradlew build
```

The compiled JAR file will be located in `build/libs/DropPrevention.jar`

## Development

### Project Structure

```
DropPrevention/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/ryzzi00/dropPrevention/
│   │   │       ├── DropPrevention.java  # Main plugin class
│   │   │       ├── Logic.java           # Data handling logic
│   │   │       ├── Lang.java            # Localization system
│   │   │       └── TabCompliter.java    # Command autocompletion
│   │   └── resources/
│   │       └── plugin.yml               # Plugin configuration
├── build.gradle                         # Build configuration
└── README.md
```

## Versions

### 1.0.0
- First release
- Basic drop enable/disable functionality
- Localization system
- Player settings storage

# bStats
![bStats](https://bstats.org/signatures/bukkit/DropPrevention.svg)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you found a bug or have a suggestion for improvement, please create an [Issue](https://github.com/ryzzi00/DropPrevention/issues) in the repository.

## Acknowledgments

Thanks to everyone who uses and supports this plugin!
