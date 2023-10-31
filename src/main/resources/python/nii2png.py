import sys
import matplotlib.pyplot as plt
import nibabel as nib
import numpy as np


def get_nii_data(nii_file):
    # 加载nii文件
    img = nib.load(nii_file)
    data = img.get_fdata()
    print(f'{data.shape[0]},{data.shape[1]},{data.shape[2]}')


def get_x_slices(nii_file, output_file):
    # 加载nii文件
    img = nib.load(nii_file)
    data = img.get_fdata()

    for x in range(1, data.shape[0] + 1):
        # 获取切片
        slice_x = data[x, :, :]
        # 旋转切片
        slice_x = np.rot90(slice_x)
        plt.imsave(f'{output_file}/slice_x_{x}.png', slice_x, cmap='gray')
    # print("x方向上的切片数为：", x)


def get_y_slices(nii_file, output_file):
    # 加载nii文件
    img = nib.load(nii_file)
    data = img.get_fdata()

    for y in range(1, data.shape[1] + 1):
        # 获取切片
        slice_y = data[:, y, :]
        # 旋转切片
        slice_y = np.rot90(slice_y)
        plt.imsave(f'{output_file}/slice_y_{y}.png', slice_y, cmap='gray')
        # print("y方向上的切片数为：", y)


def get_z_slices(nii_file, output_file):
    # 加载nii文件
    img = nib.load(nii_file)
    data = img.get_fdata()

    for z in range(1, data.shape[2] + 1):
        slice_z = data[:, :, z]
        slice_z = np.rot90(slice_z)
        plt.imsave(f'{output_file}/slice_z_{z}.png', slice_z, cmap='gray')
        # print("z方向上的切片数为：", z)


if __name__ == '__main__':
    func_name = sys.argv[1]
    nii_file = sys.argv[2]
    if func_name == "get_nii_data":
        get_nii_data(nii_file)
    else:
        out_file = sys.argv[3]
        if func_name == "get_x_slice":
            get_x_slices(nii_file, out_file)
        elif func_name == "get_y_slice":
            get_y_slices(nii_file, out_file)
        elif func_name == "get_z_slice":
            get_z_slices(nii_file, out_file)