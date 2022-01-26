package ru.geekbrains.register;

public class Registry {
    private static Registry registry = new Registry();

    public static Registry getRegistry() {
        return registry;
    }

    private BrandService brandService = new BrandService();
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();

    public Object findService(String name) {
        switch (name) {
            case "brandService":
                return brandService;
            case "userService":
                return userService;
            case "productService":
                return productService;
            default:
                throw new IllegalArgumentException("No such service");
        }
    }
}
