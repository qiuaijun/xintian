package com.xintian.mall.model.image;

/**
 * Created by aijun on 15/7/22.
 */
public class ImageStoreEntity {
    private String imageKey;
    private String imageUrl;

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageStoreEntity that = (ImageStoreEntity) o;

        if (imageKey != null ? !imageKey.equals(that.imageKey) : that.imageKey != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageKey != null ? imageKey.hashCode() : 0;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
