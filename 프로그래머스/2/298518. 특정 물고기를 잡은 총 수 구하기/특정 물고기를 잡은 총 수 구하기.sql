select count(*) as FISH_COUNT
from fish_info fi join fish_name_info fn
on fi.fish_type = fn.fish_type
where fn.fish_name = 'BASS' or fn.fish_name = 'SNAPPER'